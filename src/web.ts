import { WebPlugin } from '@capacitor/core';

import type { NativeAppInfoPlugin } from './definitions';

export class NativeAppInfoWeb extends WebPlugin implements NativeAppInfoPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
