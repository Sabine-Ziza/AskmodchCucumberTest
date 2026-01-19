//package hooks;
//
//import io.cucumber.java.*;
//
//public class CucumberHooks {
//
//    // Runs once before all scenarios
//    @BeforeAll
//    public static void beforeAllScenarios() {
//        System.out.println("=== BEFORE ALL SCENARIOS ===");
//    }
//
//    // Runs before each scenario
//    @Before
//    public void beforeEachScenario() {
//        System.out.println(">>> BEFORE SCENARIO <<<");
//    }
//
//    // Runs before each step
//    @BeforeStep
//    public void beforeEachStep() {
//        System.out.println(">>> BEFORE STEP <<<");
//    }
//
//    // Runs after each step
//    @AfterStep
//    public void afterEachStep() {
//        System.out.println(">>> AFTER STEP <<<");
//    }
//
//    // Runs after each scenario
//    @After
//    public void afterEachScenario() {
//        System.out.println(">>> AFTER SCENARIO <<<");
//    }
//
//    // Runs once after all scenarios
//    @AfterAll
//    public static void afterAllScenarios() {
//        System.out.println("=== AFTER ALL SCENARIOS ===");
//    }
//}
