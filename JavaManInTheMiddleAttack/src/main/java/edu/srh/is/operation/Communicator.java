package edu.srh.is.operation;

import java.math.BigInteger;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.srh.is.constant.LogMarker;
import edu.srh.is.util.Common;
import edu.srh.is.util.MessageUtil;
import edu.srh.is.victim.Victim;

public class Communicator {

	private static final Logger logger = LoggerFactory.getLogger(Communicator.class);

	BigInteger generator;
	BigInteger modulus;

    private static final int KEY_LENGTH = 256;


	public Communicator() {
		initiateEncryption();
	}


	public void initiateEncryption() {
        BigInteger q = BigInteger.ZERO;
        while (true) {
    		Random rnd = new Random();

            q = BigInteger.probablePrime(KEY_LENGTH, rnd);
            modulus = (q.multiply(BigInteger.TWO)).add(BigInteger.ONE); // p = 2q+1

            if (!modulus.isProbablePrime(40))
                continue;

            while (true) {
            	generator = MessageUtil.getRandomBigInteger(BigInteger.TWO, modulus.subtract(BigInteger.ONE));
                BigInteger exp = (modulus.subtract(BigInteger.ONE)).divide(q);
                if (generator.modPow(exp, modulus).compareTo(BigInteger.ONE) != 0)
                    break;
            }
            break;
        }
	}


    public BigInteger getRandomElement() {      
        return generator.modPow(MessageUtil.getRandomBigInteger(BigInteger.ONE, modulus), modulus);
    }



    public BigInteger getModulus() {
        return modulus;
    }


    public BigInteger getGenerator() {
        return generator;
    }


    public BigInteger powMod(BigInteger base, BigInteger exp){
    	BigInteger result = base.modPow(exp, this.modulus);
    	return result;
    }
	
}
