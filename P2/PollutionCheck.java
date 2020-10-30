import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class PollutionCheck {
	public static void main(String args[]) {
		ArrayList<Car> cars = new ArrayList<Car>();
		ArrayList<Truck> trucks = new ArrayList<Truck>();
		try {
			File vehicles = new File(args[0]);
			Scanner reader = new Scanner(vehicles);
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				String words[] = data.split(", ");
				if(words[3].equals("Car")) {
					Car c = new Car();
					c.setValues(words[0], words[1], words[2]);
					cars.add(c);
				}
				else if(words[3].equals("Truck")) {
					Truck t = new Truck();
					t.setValues(words[0], words[1], words[2]);
					trucks.add(t);
				}
			}
			reader.close();
		} catch(FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}

		try {
			File pollution = new File(args[1]);
			Scanner reader = new Scanner(pollution);
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				String words[] = data.split(", ");
				for(Car car: cars) {
					if(car.getRegNo().equals(words[0])) {
						car.addPollutants(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3]));
					}
				}
				for(Truck truck: trucks) {
					if(truck.getRegNo().equals(words[0])) {
						truck.addPollutants(Double.parseDouble(words[1]), Double.parseDouble(words[2]), Double.parseDouble(words[3]));
					}
				}
			}
			reader.close();
		} catch(FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}

		try {
			File queries = new File(args[2]);
			Scanner reader = new Scanner(queries);
			while(reader.hasNextLine()) {
				String data = reader.nextLine();
				String words[] = data.split(", ");
				int found = 0;
				for(Car car: cars) {
					if(car.getRegNo().equals(words[0])) {
						found = 1;
						car.checkPollutionStatus();
					}
				}
				for(Truck truck: trucks) {
					if(truck.getRegNo().equals(words[0])) {
						found = 1;
						truck.checkPollutionStatus();
					}
				}
				if(found==0) {
					System.out.println("NOT REGISTERED");
				}
			}
			reader.close();
		} catch(FileNotFoundException e) {
			System.out.println("An error occured");
			e.printStackTrace();
		}
	}
}