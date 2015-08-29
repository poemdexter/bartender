package bartender.controller

import bartender.entity.Beer
import bartender.repository.BeerRepository
import bartender.service.M2XService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestMapping('/beer')
class BeerController {

    @Autowired private BeerRepository beerRepository
    @Autowired private M2XService m2xService

    @RequestMapping(method = GET, value = '{id}')
    Beer getBeer(@PathVariable String id) {
        new Beer(id: id, temperature: m2xService.getLatestTemperature())
    }
}
