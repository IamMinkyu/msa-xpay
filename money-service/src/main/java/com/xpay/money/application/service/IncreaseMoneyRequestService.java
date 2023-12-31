package com.xpay.money.application.service;

import com.xpay.common.CountDownLatchManager;
import com.xpay.common.RechargingMoneyTask;
import com.xpay.common.SubTask;
import com.xpay.common.UseCase;
import com.xpay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.xpay.money.adapter.out.persistence.MoneyChangingRequestMapper;
import com.xpay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.xpay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.xpay.money.application.port.out.GetMembershipPort;
import com.xpay.money.application.port.out.IncreaseMoneyPort;
import com.xpay.money.application.port.out.SendRechargingMoneyTaskPort;
import com.xpay.money.domain.MemberMoney;
import com.xpay.money.domain.MoneyChangingRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

@UseCase
@RequiredArgsConstructor
@Transactional
public class IncreaseMoneyRequestService implements IncreaseMoneyRequestUseCase {

  private final GetMembershipPort membershipPort;
  private final MoneyChangingRequestMapper mapper;
  private final IncreaseMoneyPort increaseMoneyPort;
  private final SendRechargingMoneyTaskPort sendRechargingMoneyTaskPort;
  private final CountDownLatchManager countDownLatchManager;

  @Override
  public MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command) {
    // 머니의 충전.증액이라는 과정
    // 1. 고객 정보가 정상인지 확인 (멤버)
    membershipPort.getMembership(command.getTargetMembershipId());

    // 2. 고객의 연동된 계좌가 있는지, 고객의 연동된 계좌의 잔액이 충분한지도 확인 (뱅킹)

    // 3. 법인 계좌 상태도 정상인지 확인 (뱅킹)

    // 4. 증액을 위한 "기록". 요청 상태로 MoneyChangingRequest 를 생성한다. (MoneyChangingRequest)

    // 5. 펌뱅킹을 수행하고 (고객의 연동된 계좌 -> 패캠페이 법인 계좌) (뱅킹)

    // 6-1. 결과가 정상적이라면. 성공으로 MoneyChangingRequest 상태값을 변동 후에 리턴
    // 성공 시에 멤버의 MemberMoney 값 증액이 필요해요
    MemberMoneyJpaEntity memberMoneyJpaEntity = increaseMoneyPort.increaseMoney(
        new MemberMoney.MembershipId(command.getTargetMembershipId())
        ,command.getAmount());

    if(memberMoneyJpaEntity != null) {
      return mapper.mapToDomainEntity(increaseMoneyPort.createMoneyChangingRequest(
              new MoneyChangingRequest.TargetMembershipId(command.getTargetMembershipId()),
              new MoneyChangingRequest.MoneyChangingType(1),
              new MoneyChangingRequest.ChangingMoneyAmount(command.getAmount()),
              new MoneyChangingRequest.MoneyChangingStatus(1),
              new MoneyChangingRequest.Uuid(UUID.randomUUID().toString())
          )
      );
    }

    // 6-2. 결과가 실패라면, 실패라고 MoneyChangingRequest 상태값을 변동 후에 리턴
    return null;
  }

  @Override
  public MoneyChangingRequest increaseMoneyRequestAsync(IncreaseMoneyRequestCommand command) {
    //1. Subtask, task
    SubTask validateMembershipIdTask = SubTask.builder()
        .subTaskName("validateMembershipId")
        .membershipID(command.getTargetMembershipId())
        .taskType("membership")
        .status("ready")
        .build();

    SubTask validateBankingTask = SubTask.builder()
        .subTaskName("validateBanking")
        .membershipID(command.getTargetMembershipId())
        .taskType("banking")
        .status("ready")
        .build();

    List<SubTask> subTaskList = new ArrayList<>();
    subTaskList.add(validateMembershipIdTask);
    subTaskList.add(validateBankingTask);

    RechargingMoneyTask task = RechargingMoneyTask.builder()
        .taskID(UUID.randomUUID().toString())
        .taskName("rechargingMoneyTask")
        .subTaskList(subTaskList)
        .moneyAmount(command.getAmount())
        .membershipID(command.getTargetMembershipId())
        .toBankName("fastcampus") // 법인 계좌 은행 이름
        .build();

    // money increase 를 위한 task 생성, Produce
    sendRechargingMoneyTaskPort.sendRechargingMoneyTaskPort(task);

    //2. Kafka produce

    //3. Wait
    try
    {
      CountDownLatch latch = countDownLatchManager.getCountDownLatch(task.getTaskID());
      latch.await();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    //3-1. task-consumer
    //  등록된 sub-task가 모두 OK라면, -> task 결과를 Produce

    //4.Task Result Consume

    //5. Consume OK, logic
    return null;
  }
}
