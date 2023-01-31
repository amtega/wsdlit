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

import gal.xunta.amtega.wsdlit.core.history.DefaultHistoryContext;
import gal.xunta.amtega.wsdlit.core.history.HistoryContext;
import gal.xunta.amtega.wsdlit.core.model.ElementNode;
import gal.xunta.amtega.wsdlit.core.model.ServiceNode;
import gal.xunta.amtega.wsdlit.membranesoa.AssertMessages;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ComplexTypeCyclicReferenceTestCase
extends ComplexTypeTestCaseAbstract {
	/*
	 * Not elegant test, but meets requirement of testing {@code builder.isNotCyclicReference() == false}
	 * in {@code ComplexTypeConverter.convert}.
	 * It should fixed in future refactoring of this module.
	 */
	@Test
	public void isNotCyclicReferenceEqualsToFalseTest() {
		final HistoryContext historyContext = new DefaultHistoryContext();
		final HistoryContext spied = Mockito.spy( historyContext );
		Mockito
				.doReturn( true )
				.when( spied ).contains( Mockito.any(), Mockito.anyString() );
		final ConverterManager converter = new ConverterManager( historyContext );
		final ServiceNode serviceNode = converter.convert( this.schema.getDefinitions() );
		final ElementNode node = converter.convert( this.schema.getComplexType( this.name ) );
		final ElementNode firstElement = this.node.findByName( firstName );

		Assert.assertNotNull( AssertMessages.NOT_NULL_EXPECTED, node );
	}
}
