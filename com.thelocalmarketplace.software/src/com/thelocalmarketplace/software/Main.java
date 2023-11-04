// André Beaulieu, UCID 30174544

// test comment 
package com.thelocalmarketplace.software;

import com.thelocalmarketplace.hardware.SelfCheckoutStation;

import powerutility.PowerGrid;

public class Main {
	// Create a system Manager and initialize it. 
	// This system manager will store all the data and
	// keep track of the active session.
	public static void main(String[] args) {
		// Create an instance of all hardware, and enable it.
		SelfCheckoutStation hardware = new SelfCheckoutStation();
		hardware.plugIn(PowerGrid.instance());
		hardware.turnOn();
		// Create a system Manager and initialize it. 
		// This system manager will store all the data and
		// keep track of the active session.
<<<<<<< HEAD
		SystemManager sysManager = new SystemManager();
		sysManager.initialize();
	} // test comments
	//test comment 
=======
		SystemManager sysManager = new SystemManager(hardware);
	}
>>>>>>> refs/remotes/origin/main
}
