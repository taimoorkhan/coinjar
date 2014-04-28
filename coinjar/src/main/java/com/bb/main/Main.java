package com.bb.main;

import com.bb.coins.AbstractCoinProductsFactory;
import com.bb.coins.Coin;
import com.bb.coins.CoinJar;
import com.bb.coins.impl.us.UsCoinProductsFactory;
import com.bb.coins.impl.us.UsVolumeUnits;

/**
 * Main Class.
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        AbstractCoinProductsFactory coinFactory = new UsCoinProductsFactory();
        CoinJar coinJar = coinFactory.makeCoinJar("32" , UsVolumeUnits.FLUID_OUNCES_STR); //32 fluid ounces = 32 * 1000 * 1000 micro fluid ounces.
        
        for(int i = 0 ; i < 10; i++){
        	Coin c = coinFactory.mintCoin("50");
        	coinJar.addCoin(c);
        }
        
        System.out.println("total amount in jar = " + coinJar.getMonetaryAmount().getValue() + " " + coinJar.getMonetaryAmount().getUnits().asString());
        System.out.println("Remaining volume = " + coinJar.getRemainingCapacity().getValue() + " " + coinJar.getRemainingCapacity().getUnits().asString());
        
        coinJar.emptyJar();
        System.out.println("total amount in jar = " + coinJar.getMonetaryAmount().getValue() + " " + coinJar.getMonetaryAmount().getUnits().asString());
        System.out.println("Remaining volume = " + coinJar.getRemainingCapacity().getValue() + " " + coinJar.getRemainingCapacity().getUnits().asString());
    }
}
