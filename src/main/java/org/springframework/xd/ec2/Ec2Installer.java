/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.xd.ec2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author glenn renfro
 * 
 */
public class Ec2Installer {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext(
					"META-INF/xdinstaller-context.xml");

			context.refresh();
			EC2Util util = context.getBean(EC2Util.class);

			util.printBanner();

			Ec2InstallerCommandLineParser parser = new Ec2InstallerCommandLineParser(
					args);
		} finally {
			if (context != null) {
				context.close();
			}
		}
	}

}