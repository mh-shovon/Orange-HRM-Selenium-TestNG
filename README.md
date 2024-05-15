Generate report using allure:
   1. Install allure: Command: "scoop install allure" or download the allure zip and set it in the environment variable.
   2. Check allure: Command: "allure --version"
   3. Add the dependency(From maven repository) in the build.gradle file and reload the gradle file.
   4. Generate allure report: Command: "allure generate allure-results"
   5. Serve the report(visualization): Command: " allure serve allure-results --clean -output"
   6. Delete the "allure-results" & "allure-report" folders before running the project every time.
