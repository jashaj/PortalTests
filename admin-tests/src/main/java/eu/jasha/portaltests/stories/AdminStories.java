/*
 * Copyright 2012 Jasha Joachimsthal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.jasha.portaltests.stories;

import java.util.List;

import org.jbehave.core.io.StoryFinder;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

/**
 * Handles story for administrators
 */
public class AdminStories extends PortalStories {

  @Override
  protected List<String> storyPaths() {
    return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(), asList("**/deleteNewUser.story"), null);
  }
}
