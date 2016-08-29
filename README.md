# copyAttributeValueOperation

An author operation in Oxygen XML editor for copying an attribute value in author mode. When the attribute value is displayed as static text in author view, it cannot be selected and copied. This author operation makes it possible to copy such an attribute value, e.g. by means of a button.

This version is specific for the project ["Digitales Familiennamenwörterbuch Deutschlands (DFD)"](http://www.namenforschung.net/dfd/woerterbuch/liste/) and copies `@xml:id` in two specific contexts, the root element and an "anchor" element.

### Version
1.0.0

### Installation and Requirements

Oxygen XML Editor version 16.1 and higher.

For your own use, adapt the source code, e.g.

* change the name of the attribute from `@xml:id` to the attribute you want to copy
* change the context from which the attribute should be copied

For use in the author mode in oXygen XML Editor, implement an author action in the document types/frameworks section. For more information on this, [see the oXygen XML Editor docs](https://www.oxygenxml.com/doc/versions/18.0/ug-editor/tasks/dg-configuring-actions-menus-toolbar.html).

### Current specific usage

The author operation copies the attribute value of `@xml:id` and uses these conditions:

* if the surrounding context is an "anchor" element, copy `@xml:id` from this element
* if not, copy `@xml:id` from the root element

### License
The MIT License (MIT)

Copyright (c) 2016 Digitales Familiennamenwörterbuch Deutschlands (DFD) at the TU Darmstadt and the Akademie der Wissenschaften und der Literatur Mainz

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.