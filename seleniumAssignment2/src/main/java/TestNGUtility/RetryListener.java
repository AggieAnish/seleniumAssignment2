package TestNGUtility;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation testAnnotation, Class testClass,
                          Constructor testConstructor, Method testMethod)	{

                    testAnnotation.setRetryAnalyzer((Class<? extends IRetryAnalyzer>) Retry.class);

    }
}