import { WebPlugin } from '@capacitor/core';

import type { NativeAppInfoPlugin } from './definitions';

export class NativeAppInfoWeb extends WebPlugin implements NativeAppInfoPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getAppInstaller(): Promise<{ installer: string | null }> {
    console.log('Web platform does not support getAppInstaller');
    return { installer: null };
  }

  async getManifestValues(): Promise<{ values: Record<string, any> }> {
    console.log('Web platform does not support getManifestValues');
    return { values: {} };
  }
}
