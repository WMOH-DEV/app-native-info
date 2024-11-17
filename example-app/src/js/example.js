import { NativeAppInfo } from 'app-native-info';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    NativeAppInfo.echo({ value: inputValue })
}
