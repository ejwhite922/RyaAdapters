/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rya.jena.legacy.graph.query;

import org.apache.jena.graph.Triple;

/**
 * A Matcher knows how to match itself against a concrete triple (the triple
 * to be matched) and a domain (of bindings to check and extend). It is part
 * of the improved-we-hope PatternStage code.
 */
public abstract class Matcher {
    /**
     * @return {@code true} if we match the triple {@code t} given the bindings
     * in {@code d}, updating those bindings if appropriate; the bindings
     * may be updated even if the match answers {@code false}.
     */
    public abstract boolean match(Domain d, Triple t);

    /**
     * This matcher always answers {@code true} and doesn't even look at
     * the domain, never mind update it.
     */
    public static final Matcher ALWAYS = new Matcher() {
        @Override
        public boolean match(final Domain d, final Triple t) {
            return true;
        }
    };
}