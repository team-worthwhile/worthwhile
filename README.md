## About

Worthwhile is an application that makes proving simple programs accessible and fun! It was developed as a project for the course "Praxis der Softwareentwicklung" at the University of Karlsruhe at the [Institute for Theoretical Informatics](http://formal.iti.kit.edu).

## Z3

[Z3](http://research.microsoft.com/en-us/um/redmond/projects/z3/) is a theorem prover developed by Microsoft Research. A recent build for Linux [is available on their website](http://research.microsoft.com/en-us/um/redmond/projects/z3/download.html). To be able to use Z3 from within Worthwhile, you should put the following script in your `$PATH` (named `z3`):

	#!/usr/bin/env bash
	/path/to/your/z3/bin/z3 -smt2 -in

## Building
Worthwhile is built on the Eclipse Platform. Eclipse 3.7.1 and Maven 3 or later are required to build the project.

Worthwhile uses the [Eclipse Xtext framework](http://www.eclipse.org/Xtext/) and the [Xtext Typesystem framework](http://code.google.com/a/eclipselabs.org/p/xtext-typesystem/). Therefore, to build a project, an Eclipse environment with these plugins installed is required. [Itemis](http://www.itemis.de/) provides prebuilt Eclipse binaries with these plugins already installed on [their website](http://www.itemis.de/). The Xtext Typesystem plugins (Version 2.0-beta, available in the ["Downloads" area of their Google Code page](http://code.google.com/a/eclipselabs.org/p/xtext-typesystem/downloads/list)) should be placed in the `plugins/` directory of your Eclipse installation.

First, Eclipse projects need to be generated to be able to build the model.

	cd implementierung/src
	mvn eclipse:eclipse

After this step has completed, open Eclipse, select *File → Import... → Existing Projects into Workspace* and choose the `implementierung/src` directory. Import all the projects and wait for Eclipse to stabilize in flight.

Find `edu.kit.iti.formal.pse.worthwhile.model/model/Worthwhile.genmodel`, open it, right-click the *Worthwhile* entry in the tree and select *Generate Model Code*.

Now, find `edu.kit.iti.formal.pse.worthwhile/src/edu.kit.iti.formal.pse.worthwhile/GenerateWorthwhile.mwe2`. Right-click it, select *Debug As → MWE2 Workflow*.

You might also need to add `com.google.inject` as a dependency to the product. Find `edu.kit.iti.formal.pse.worthwhile.product/META-INF/MANIFEST.MF`, open it, select the *Dependencies* tab and add `com.google.inject` as a dependency.

You should now be ready to go! Find `edu.kit.iti.formal.pse.worthwhile.product/worthwhile.product.launch`. Right-click it, select *Debug As → worthwhile.product*. Boom! You're in for endless hours of fun with Worthwhile!
