package com.saljuma.workflow;

import com.saljuma.workflow.AbstractNeo4jIT;
import com.saljuma.workflow.WorkflowApp;
import com.saljuma.workflow.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { WorkflowApp.class, TestSecurityConfiguration.class })
@ExtendWith(AbstractNeo4jIT.class)
public @interface IntegrationTest {
}
