/*
 * *********************************************************************
 *  Copyright(c) 2015 e-Rewards, Inc. All rights reserved.
 *  PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * *********************************************************************
 */

package bartender.controller

import bartender.entity.Beer
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET

@RestController
@RequestMapping('/')
class IndexController {

    @RequestMapping(method = GET)
    String getIndex() {
        'visit https://github.com/poemdexter/bartender for more info'
    }
}
