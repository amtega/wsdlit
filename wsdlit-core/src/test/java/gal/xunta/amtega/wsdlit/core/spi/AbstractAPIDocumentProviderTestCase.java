package gal.xunta.amtega.wsdlit.core.spi;

/*-
 * #%L
 * wsdlit-core
 * %%
 * Copyright (C) 2021 - 2022 Axencia para a Modernización Tecnolóxica de Galicia (AMTEGA) - Xunta de Galicia
 * %%
 * This file is part of "wsdlit".
 *
 * "wsdlit" is free software: you can redistribute it and/or modify
 * it under the terms of:
 * European Union Public License, either Version 1.2 or – as soon
 * they will be approved by the European Commission - subsequent versions of
 * the EUPL;
 *
 * "wsdlit" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * European Union Public License for more details.
 *
 * You may obtain a copy of tce European Union Public Licence at:
 * http://joinup.ec.europa.eu/software/page/eupl/licence-eupl
 * #L%
 */

import gal.xunta.amtega.wsdlit.core.AssertMessages;
import gal.xunta.amtega.wsdlit.core.model.APIDocument;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author rriaqui
 * @since 1.0.0
 */
public class AbstractAPIDocumentProviderTestCase {
    private final AbstractAPIDocumentProvider provider = new AbstractAPIDocumentProvider() {
        @Override
        public APIDocument convert(List< String > sources ) {
            return null;
        }
    };

    @Test
    public void getSourcesDirectoryNullTest() {
        Assert.assertNull( AssertMessages.NULL_EXPECTED, provider.getSourcesDirectory() );
    }

    @Test
    public void getSourcesDirectoryNotNullTest() {
        final File expected = new File( "" ).getAbsoluteFile();
        provider.setSourcesDirectory( expected );
        Assert.assertEquals( AssertMessages.EQUALS_EXPECTED, expected, provider.getSourcesDirectory() );
    }
}
