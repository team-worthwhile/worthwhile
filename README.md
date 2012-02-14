## About

Worthwhile is an application that makes proving simple programs accessible and fun! It was developed as a project for the course "Praxis der Softwareentwicklung" at the University of Karlsruhe at the [Institute for Theoretical Informatics](http://formal.iti.kit.edu).

## Z3

[Z3](http://research.microsoft.com/en-us/um/redmond/projects/z3/) is a theorem prover developed by Microsoft Research. A recent build for Linux [is available on their website](http://research.microsoft.com/en-us/um/redmond/projects/z3/download.html). To be able to use Z3 from within Worthwhile, you should put the Z3 binary in your `$PATH` (named `z3`).

## Building
Worthwhile is built on the Eclipse Platform. Java SE 6, Eclipse 3.7.1 and Maven 3 or later are required to build the project.

Worthwhile uses the [Eclipse Xtext framework](http://www.eclipse.org/Xtext/) and the [Xtext Typesystem framework](http://code.google.com/a/eclipselabs.org/p/xtext-typesystem/). Therefore, to build a project, an Eclipse environment with these plugins installed is required. [Itemis](http://www.itemis.de/) provides prebuilt Eclipse binaries with these plugins already installed on [their website](http://www.itemis.de/). The Xtext Typesystem plugins (Version 2.0-beta, available in the ["Downloads" area of their Google Code page](http://code.google.com/a/eclipselabs.org/p/xtext-typesystem/downloads/list)) should be placed in the `plugins/` directory of your Eclipse installation.

The easiest way to run *Worthwhile* from source is launching it from within an existing Eclipse instance. Because for some reason, *maven-eclipse-plugin* requires all build artifacts to be in place when generating `.project` files for Eclipse, all projects have to be built and the build artifacts installed to the local Maven repository before generating the project files. If you have figured out a better way to do this, please let us know.

	cd implementierung/src
	mvn install -Dmaven.test.skip=true
	mvn eclipse:eclipse

After this step has completed, open Eclipse, select *File → Import... → Existing Projects into Workspace* and choose the `implementierung/src` directory. Import all the projects and wait for Eclipse to stabilize in flight.

You might also need to add `com.google.inject` as a dependency to the product. Find `edu.kit.iti.formal.pse.worthwhile.product/META-INF/MANIFEST.MF`, open it, select the *Dependencies* tab and add `com.google.inject` as a dependency.

Nobody knows why, but to get everything to work you have to open `edu.kit.iti.formal.pse.worthwhile.product/worthwhile.product`, select the *Dependencies* tab and press the *Add Required Plug-ins* button. Now, switch back to the *Overview* tab and in the *Testing* section first select *Synchronize* and then *Launch an Eclipse application*. Boom! You're in for endless hours of fun with Worthwhile!
