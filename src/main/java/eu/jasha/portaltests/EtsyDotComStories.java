package eu.jasha.portaltests;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.spring.SpringApplicationContextFactory;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.jbehave.web.selenium.ContextView;
import org.jbehave.web.selenium.LocalFrameContextView;
import org.jbehave.web.selenium.SeleniumConfiguration;
import org.jbehave.web.selenium.SeleniumContext;
import org.jbehave.web.selenium.SeleniumContextOutput;
import org.jbehave.web.selenium.SeleniumStepMonitor;
import org.springframework.context.ApplicationContext;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.web.selenium.WebDriverHtmlOutput.WEB_DRIVER_HTML;

public class EtsyDotComStories extends JUnitStories {

    public EtsyDotComStories() {

        CrossReference crossReference = new CrossReference().withJsonOnly().withOutputAfterEachStory(true)
                .excludingStoriesWithNoExecutedScenarios(true);
        ContextView contextView = new LocalFrameContextView().sized(640, 120);
        SeleniumContext seleniumContext = new SeleniumContext();
        SeleniumStepMonitor stepMonitor = new SeleniumStepMonitor(contextView, seleniumContext,
                crossReference.getStepMonitor());
        Format[] formats = new Format[] { new SeleniumContextOutput(seleniumContext), CONSOLE, WEB_DRIVER_HTML };
        StoryReporterBuilder reporterBuilder = new StoryReporterBuilder()
                .withCodeLocation(codeLocationFromClass(EtsyDotComStories.class)).withFailureTrace(true)
                .withFailureTraceCompression(true).withDefaultFormats().withFormats(formats)
                .withCrossReference(crossReference);

        Configuration configuration = new SeleniumConfiguration().useSeleniumContext(seleniumContext)
                .useFailureStrategy(new FailingUponPendingStep())
                .useStoryControls(new StoryControls().doResetStateBeforeScenario(false)).useStepMonitor(stepMonitor)
                .useStoryLoader(new LoadFromClasspath(EtsyDotComStories.class))
                .useStoryReporterBuilder(reporterBuilder);
        useConfiguration(configuration);

        ApplicationContext context = new SpringApplicationContextFactory("etsy-steps.xml").createApplicationContext();
        useStepsFactory(new SpringStepsFactory(configuration, context));

    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(), asList("**/" + System.getProperty("storyFilter", "*")
                + ".story"), null);
    }

}
