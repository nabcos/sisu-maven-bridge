/*******************************************************************************
 * Copyright (c) 2010-2011 Sonatype, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 * The Eclipse Public License is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 * The Apache License v2.0 is available at
 *   http://www.apache.org/licenses/LICENSE-2.0.html
 * You may elect to redistribute this code under either of these licenses.
 *******************************************************************************/
package org.sonatype.sisu.maven.bridge.support.artifact;

import static org.sonatype.sisu.maven.bridge.Names.LOCAL_ARTIFACT_RESOLVER_ROOT_DIR;

import java.io.File;
import javax.inject.Inject;
import javax.inject.Named;

import org.sonatype.inject.Nullable;
import org.sonatype.sisu.maven.bridge.MavenArtifactResolver;
import org.sonatype.sisu.maven.bridge.support.artifact.internal.LocalMavenArtifactResolverSupport;

public class MutableLocalMavenArtifactResolver
    extends LocalMavenArtifactResolverSupport
    implements MavenArtifactResolver
{

    private File basedir;

    @Inject
    MutableLocalMavenArtifactResolver( final @Nullable @Named( LOCAL_ARTIFACT_RESOLVER_ROOT_DIR ) File basedir )
    {
        assertNotNull( basedir, "repository base directory not specified" );

        this.basedir = basedir;
    }

    @Override
    protected File getBaseDir()
    {
        return basedir;
    }

    public void setBaseDir( final File basedir )
    {
        this.basedir = basedir;
    }

}
