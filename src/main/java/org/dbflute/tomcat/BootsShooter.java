/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.dbflute.tomcat;

/**
 * @author jflute
 */
public class BootsShooter {

    protected final TomcatBoot[] boots;

    public BootsShooter(TomcatBoot... boots) {
        if (boots == null) {
            throw new IllegalArgumentException("The argument 'boots' should not be null");
        }
        if (boots.length == 0) {
            throw new IllegalArgumentException("The boots should have one or more elements but empty.");
        }
        this.boots = boots;
    }

    public void bootAwait() {
        for (TomcatBoot boot : boots) {
            boot.bootAwait();
        }
        for (TomcatBoot boot : boots) {
            boot.await();
        }
    }
}