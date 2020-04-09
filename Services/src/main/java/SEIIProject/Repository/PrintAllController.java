package SEIIProject.Repository;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SEIIProject.Model.AbstractUser;

@RestController
public class PrintAllController {
	
	DataRepository dr = new DataRepository();
	
	@RequestMapping("/printAll")
	public ArrayList<AbstractUser> printAll() {
		Loader l = new UserLoader();
		//ArrayList<AbstractUser> au = new ArrayList();
		//AbstractUser u = null;
		return l.loadALL();
	}
}
