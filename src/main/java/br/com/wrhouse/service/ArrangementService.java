package br.com.wrhouse.service;

import br.com.wrhouse.model.Arrangement;
import br.com.wrhouse.model.ArrangementLog;
import br.com.wrhouse.repository.ArrangementLogRepository;
import br.com.wrhouse.repository.ArrangementRepository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class ArrangementService {

    @Inject
    ArrangementRepository arrangementRepository;

    @Inject
    ArrangementLogRepository arrangementLogRepository;

    public void updateValues(ArrangementLog arrangementLog) {
        Arrangement arrangement = arrangementRepository
                .find("constrolCode.id", arrangementLog.getCode().getId())
                .firstResult();

    }
}
