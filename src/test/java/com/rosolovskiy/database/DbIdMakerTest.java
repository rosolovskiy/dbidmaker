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
}
