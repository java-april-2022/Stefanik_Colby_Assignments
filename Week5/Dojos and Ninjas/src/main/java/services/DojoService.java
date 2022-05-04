package services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import models.Dojo;
import repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}

    public List<Dojo> all() {
        return dojoRepo.findAll();
    }

    public Dojo create(Dojo dojo) {
    	System.out.println(dojo.getID());
        return dojoRepo.save(dojo);
    }

    public Dojo find(Long id) {
        Optional<Dojo> result = dojoRepo.findById(id);
        if(result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
}
