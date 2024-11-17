# app-native-info

Getting app info through capacitor

## Install

```bash
npm install app-native-info
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`getAppInstaller()`](#getappinstaller)
* [`getManifestValues()`](#getmanifestvalues)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### getAppInstaller()

```typescript
getAppInstaller() => Promise<{ installer: string | null; }>
```

**Returns:** <code>Promise&lt;{ installer: string | null; }&gt;</code>

--------------------


### getManifestValues()

```typescript
getManifestValues() => Promise<{ values: Record<string, any>; }>
```

**Returns:** <code>Promise&lt;{ values: <a href="#record">Record</a>&lt;string, any&gt;; }&gt;</code>

--------------------


### Type Aliases


#### Record

Construct a type with a set of properties K of type T

<code>{ [P in K]: T; }</code>

</docgen-api>
