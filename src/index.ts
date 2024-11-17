import { registerPlugin } from '@capacitor/core';

import type { NativeAppInfoPlugin } from './definitions';

const NativeAppInfo = registerPlugin<NativeAppInfoPlugin>('NativeAppInfo', {
  web: () => import('./web').then((m) => new m.NativeAppInfoWeb()),
});

export * from './definitions';
export { NativeAppInfo };
