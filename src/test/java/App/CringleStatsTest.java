package App;
import Controller.Controller;
import Model.Model;
import View.View;
import static org.junit.Assert.*;

import org.junit.Test;

public class CringleStatsTest {

	@Test
	public void testMain() {
            Model model = new Model();
            View view = new View();
            Controller controller = new Controller(model, view);
            //assertEquals("Guren no Yumiya", model.getStData().getStats().getSong().get(0).getTitle());   
	}

}
