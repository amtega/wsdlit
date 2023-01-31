package gal.xunta.amtega.wsdlit.membranesoa.converter;

/*-
 * #%L
 * wsdlit-membranesoa
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

import com.predic8.schema.ModelGroup;
import gal.xunta.amtega.wsdlit.core.model.ElementNodeBuilder;
import gal.xunta.amtega.wsdlit.core.model.NamespacePrefixCache;
import gal.xunta.amtega.wsdlit.membranesoa.model.MembraneSOANamespacePrefixCache;
import org.junit.Test;

public class ModelGroupConverterThrowsExceptionTestCase {
    private final NamespacePrefixCache cache = new MembraneSOANamespacePrefixCache();
    private final ConverterManager converterManager = ConverterManager.getInstance().initNamespacePrefixCache( cache );

    private final ModelGroupConverter converter = converterManager.getModelGroupConverter();

    @Test( expected = IllegalArgumentException.class )
    public void createModelGroupThrowsIllegalArgumentExceptionTest() {
        final ModelGroup modelGroup = new UnknownModelGroup();
        converter.createModelGroup( modelGroup, new ElementNodeBuilder() );

    }

    static class UnknownModelGroup extends ModelGroup {
        @Override
        public String getElementName() {
            return "UNKNOWN";
        }
    }
}
