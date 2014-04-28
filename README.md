Overview:
---------
This project contains an implementation of a coin jar which only accepts us coins.  The jar can be drained and reset to 0 monetary amount.


Installation:
-------------
You will need to install maven and Java 7.  To use the given pom you will need to export a JAVA_HOME_7 environment variable.

From the commandline type go the root folder containing the pom.xml fiel and type  'mvn install'.  This will compile and the project.

To run the sample Main method type 'mvn exec:java -Dexec.mainClass="com.bb.main.Main"'.  


Design Overview:
----------------

Abstractions:

This project has the following main abstractions:

1.  Coin interface: This represents a coin which has a monetary denomination as well as a physical volume.
2.  CoinJar interface: This represents a coin jar to which we can add coins until the jar will reach its capacity.  This jar can be drained of all coins in which case it will be reset.
3.  An abstract factory to create the related products of coins and jars that contain them.
4.  Abstract base classes to aid in implementation of different families of jars and coins.
5.  A concrete implementation of U.S. coins and jars along with supported monetary and volume types.



Client Usage:

The client first gets a reference to an abstract factory.  This abstract factory is used to then create an instance of coin jar.  The same factory can be used to get instances of coins that are compatible with the coin jar.

AbstractCoinProductsFactory coinFactory = new UsCoinProductsFactory();
CoinJar coinJar = coinFactory.makeCoinJar("32" , UsVolumeUnits.FLUID_OUNCES_STR); 

Then coins can be made from the factory like:

Coin c = coinFactory.mintCoin("25");

The above line will create a 25 cents coin from this abstract factory and since it is a U.S. coins abstract factory, the above code will create a 25 cents coin.


Abstract Factories:
A concrete implementation of a U.S. coin products abstract factory is given in the com.bb.coins.impl.us package.  To add support for another locale/country create another package and provide concrete implementations for the abstract coin products factory as well as Coin and CoinJar.
        




