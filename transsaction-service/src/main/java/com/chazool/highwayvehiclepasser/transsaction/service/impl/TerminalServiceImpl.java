package com.chazool.highwayvehiclepasser.transsaction.service.impl;

import com.chazool.highwayvehiclepasser.model.transactionservice.Terminal;
import com.chazool.highwayvehiclepasser.transsaction.repository.TerminalRepository;
import com.chazool.highwayvehiclepasser.transsaction.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalRepository terminalRepository;

    @Override
    public Terminal save(Terminal terminal) {
        return terminalRepository.save(terminal);
    }

    @Override
    public Terminal update(Terminal terminal) {
        return terminalRepository.save(terminal);
    }

    @Override
    public Terminal delete(int id) {
        Terminal terminal = findById(id);
        terminal.setActive(true);

        return terminalRepository.save(terminal);
    }

    @Override
    public Terminal findById(int id) {
        Optional<Terminal> optionalTerminal = terminalRepository.findById(id);

        return optionalTerminal.isPresent() ? optionalTerminal.get() : null;
    }

    @Override
    public List<Terminal> findByAll() {
        return terminalRepository.findAll();
    }

    @Override
    public List<Terminal> findByLocation(int locationId) {
        return terminalRepository.findByLocationId(locationId);
    }
}
