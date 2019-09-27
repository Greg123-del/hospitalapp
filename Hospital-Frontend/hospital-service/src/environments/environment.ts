import {PlatformLocation } from '@angular/common';

function loadJSON(filePath) {
  const json = loadTextFileAjaxSync(filePath, "application/json");
  return JSON.parse(json);
}

function loadTextFileAjaxSync(filePath, mimeType) {
  const xmlhttp = new XMLHttpRequest();
  xmlhttp.open("GET", filePath, false);
  if (mimeType != null) {
    if (xmlhttp.overrideMimeType) {
      xmlhttp.overrideMimeType(mimeType);
    }
  }
  xmlhttp.send();
  if (xmlhttp.status == 200) {
    return xmlhttp.responseText;
  }
  else {
    return null;
  }
}

//export const environment = loadJSON(window.location.protocol+"//"+window.location.host+'/esbclient/assets/config.json');
export const environment = loadJSON('assets/config.json');

localStorage.setItem('environment.production', environment.production + "");
localStorage.setItem('environment.mainApiUrl', environment.mainApiUrl);