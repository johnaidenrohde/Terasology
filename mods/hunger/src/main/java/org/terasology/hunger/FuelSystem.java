/*
 * Copyright 2012 Esa-Petri Tirkkonen <esereja@yahoo.co.uk>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.hunger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terasology.componentSystem.UpdateSubscriberSystem;
import org.terasology.entitySystem.EntityManager;
import org.terasology.entitySystem.EntityRef;
import org.terasology.entitySystem.EventHandlerSystem;
import org.terasology.entitySystem.RegisterComponentSystem;
import org.terasology.game.CoreRegistry;

/**
 * @author Esa-Petri Tirkkonen <esereja@yahoo.co.uk>
 */
@RegisterComponentSystem(authorativeOnly = true)
public class FuelSystem implements EventHandlerSystem, UpdateSubscriberSystem {
    private static final Logger logger = LoggerFactory.getLogger(FuelSystem.class);
    private EntityManager entityManager;

    public void initialise() {
        entityManager = CoreRegistry.get(EntityManager.class);
    }

    @Override
    public void shutdown() {
    }

    public void update(float delta) {
        for (EntityRef entity : entityManager.iteratorEntities(FuelComponent.class)) {

            FuelComponent fuelComp = entity.getComponent(FuelComponent.class);
            logger.info("Fuel left: {}", fuelComp.quantity);
            //entity.saveComponent(hunger);
        }
    }

}
