import one.team.StatsServerApp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(classes = StatsServerApp.class)
class StatsServerAppTests {

	@Test
	void contextLoads() {
	}

}
