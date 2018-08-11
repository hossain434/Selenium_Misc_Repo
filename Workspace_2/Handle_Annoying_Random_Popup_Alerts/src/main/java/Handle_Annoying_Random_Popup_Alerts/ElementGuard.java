package Handle_Annoying_Random_Popup_Alerts;
ublic class ElementGuard {

    public static WebElement guard(WebElement element) {
        ElementProxy proxy = new ElementProxy(element);
        WebElement wrappdElement = (WebElement) Proxy.newProxyInstance(ElementProxy.class.getClassLoader(),
                                                                       new Class[] { WebElement.class },
                                                                       proxy);
        return wrappdElement;
    }

}