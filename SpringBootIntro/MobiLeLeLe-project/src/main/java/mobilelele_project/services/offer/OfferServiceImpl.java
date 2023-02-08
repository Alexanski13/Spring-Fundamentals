package mobilelele_project.services.offer;

import mobilelele_project.services.init.DatabaseInitService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService, DatabaseInitService {
    @Override
    public void dbInit() {
    }

    @Override
    public boolean isDbInit() {
        return false;
    }
}
