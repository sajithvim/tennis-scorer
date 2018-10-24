package com.dius.tennisscorer.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.dius.tennisscorer.unittests.TestGameScorer;
import com.dius.tennisscorer.unittests.TestModel;
import com.dius.tennisscorer.unittests.TestSetScorer;

@RunWith(Suite.class)
@SuiteClasses({ TestModel.class, TestGameScorer.class, TestSetScorer.class, TestMatch.class })

public class AllTests {

}
