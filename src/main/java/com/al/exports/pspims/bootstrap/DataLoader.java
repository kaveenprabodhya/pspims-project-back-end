package com.al.exports.pspims.bootstrap;

import com.al.exports.pspims.domain.Agent;
import com.al.exports.pspims.repository.AgentRepository;
import com.al.exports.pspims.shared.enums.AgentDepartmentTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final AgentRepository agentRepository;

    @Override
    public void run(String... args) throws Exception {
        int count = agentRepository.findAll().size();

        if (count == 0 ){
            loadAgentData();
        }
    }

    private void loadAgentData(){
        Agent newAgent = Agent.builder()
                .firstName("Kaveen")
                .lastName("Prabodhya")
                .agentDepartment(AgentDepartmentTypeEnum.LOGISTICS)
                .address("75 A, Colombo 01")
                .email("agent1@example.com")
                .performanceRate(3.7f)
                .build();

        agentRepository.save(newAgent);
    }
}
