package com.PYYNE.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import com.PYYNE.challenge.pyyne.challenge.bank.controller.BankController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChallengeApplicationTests {
	@Mock
	private BankController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
