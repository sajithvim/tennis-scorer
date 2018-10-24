package com.dius.tennisscorer.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.dius.tennisscorer.unittests.TestScorer;
import com.dius.tennisscorer.unittests.TestTieBreaker;

@RunWith(Suite.class)
@SuiteClasses({
        TestScorer.class,
        TestTieBreaker.class,
        TestMatch.class})

public class AllTests {

}
