package net.netease;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import net.netease.filter.LogFilter;


public class TestLogFilter extends TestCase {
	public static Test suite()
    {
        return new TestSuite( LogFilter.class );
    }
}
