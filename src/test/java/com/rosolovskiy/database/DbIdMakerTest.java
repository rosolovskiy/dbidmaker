package com.rosolovskiy.database;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.SocketException;
import java.net.UnknownHostException;

public class DbIdMakerTest {

    @Test
    public void idsOrderTest() throws UnknownHostException, SocketException {
        DbIdMaker idMaker = new DbIdMaker();
        final long id1 = idMaker.makeId();
        final long id2 = idMaker.makeId();
        Assert.assertTrue(id1 < id2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void tooBigMachineId() {
        final long maxMachineId = -1L ^ (-1L << 10); // 10 bits is a maximum size of machine id in generated id
        new DbIdMaker(maxMachineId + 1);
    }

    @Test
    public void positiveTest() throws UnknownHostException, SocketException {
        DbIdMaker idMakerMac = new DbIdMaker();
        DbIdMaker idMakerCustom = new DbIdMaker(5);
        final long id1 = idMakerMac.makeId();
        final long id2 = idMakerCustom.makeId();
        Assert.assertTrue(id1 > 0);
        Assert.assertTrue(id2 > 0);
    }
}
