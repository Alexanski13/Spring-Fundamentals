package mobilelele_project.services.offer;

import mobilelele_project.repositories.OfferRepository;
import mobilelele_project.services.init.DatabaseInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService, DatabaseInitService {
    private OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return this.offerRepository.count() > 0;
    }
}
