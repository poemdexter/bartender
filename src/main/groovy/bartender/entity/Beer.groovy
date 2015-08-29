package bartender.entity

import org.springframework.data.annotation.Id

class Beer {
    @Id String id
    double temperature
}
