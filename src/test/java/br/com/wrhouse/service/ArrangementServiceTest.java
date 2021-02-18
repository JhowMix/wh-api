package br.com.wrhouse.service;

import br.com.wrhouse.model.ArrangementLog;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ArrangementServiceTest {

    @Inject
    ArrangementService arrangementService;

    @Test
    public void testUpdating() {
        ArrangementLog arrangementLog = new ArrangementLog();

    }
}
