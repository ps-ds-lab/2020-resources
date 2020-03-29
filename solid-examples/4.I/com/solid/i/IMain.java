package com.solid.i;

import java.util.Date;

import com.solid.i.bad.BadInvoicePrinter;
import com.solid.i.bad.BadInvoicePrinter_I;
import com.solid.i.bad.SomeOtherBadInvoicePrinter;
import com.solid.i.good.GoodInvoicePrinter;
import com.solid.i.good.GoodInvoicePrinter_I;
import com.solid.i.good.GoodComplexInvoicePrinter;
import com.solid.i.good.GoodComplexInvoicePrinter_I;

public class IMain {

	public static void main(String[] args) {
		testBadI();
		testGoodI();
	}

	private static void testBadI() {
		Invoice invoice = new Invoice(-132523);
		ComplexInvoice complexInvoice = new ComplexInvoice(21439, new Date());

		BadInvoicePrinter_I badInvoicePrinter = new BadInvoicePrinter();
		badInvoicePrinter.print(invoice);
		badInvoicePrinter.someOtherPrintMethod(invoice);
		badInvoicePrinter.printComplexInvoice(complexInvoice); //why should I be able to do this?

		BadInvoicePrinter_I someOtherBadInvoicePrinter = new SomeOtherBadInvoicePrinter();
		someOtherBadInvoicePrinter.print(invoice); //why should I be able to do this?
		someOtherBadInvoicePrinter.someOtherPrintMethod(invoice); //why should I be able to do this?
		someOtherBadInvoicePrinter.printComplexInvoice(complexInvoice);
	}

	private static void testGoodI() {
		Invoice invoice = new Invoice(423);
		ComplexInvoice complexInvoice = new ComplexInvoice(242, new Date());

		GoodInvoicePrinter_I goodInvoicePrinter = new GoodInvoicePrinter();
		goodInvoicePrinter.print(invoice);
		goodInvoicePrinter.someOtherPrintMethod(invoice);
		// goodInvoicePrinter.printComplexInvoice(complexInvoice); // unavailable! great.

		GoodComplexInvoicePrinter_I goodComplexInvoicePrinter = new GoodComplexInvoicePrinter();
		// other 2 methods are unavailable
		goodComplexInvoicePrinter.printComplexInvoice(complexInvoice);
	}

}
