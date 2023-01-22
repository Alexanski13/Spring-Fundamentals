package mobilelele_project.services.model;

import mobilelele_project.repositories.ModelRepository;
import mobilelele_project.services.init.DatabaseInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService, DatabaseInitService {
    private ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return this.modelRepository.count() > 0;
    }
}
