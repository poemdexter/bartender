package bartender.repository

import bartender.entity.Beer
import org.springframework.data.mongodb.repository.MongoRepository

interface BeerRepository extends MongoRepository<Beer, String> {}